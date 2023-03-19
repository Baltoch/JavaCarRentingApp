/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class AppCalendar {
    
    static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    RightArrowButton rightArrow;
    LeftArrowButton leftArrow;
    JLabel month;
    CalendarButton[][] buttons;
    
    JLabel monday;
    JLabel tuesday;
    JLabel wednesday;
    JLabel thursday;
    JLabel friday;
    JLabel saturday;
    JLabel sunday;
    
    CalendarButton selectedCalendar;
    
    public AppCalendar(int x, int y, int width, int height)
    {
        double widthRatio = width/320.0;
        double heightRatio = height/355.0;
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(GregorianCalendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(1);
        Date today = new Date();
        calendar.setTime(today);
        
        rightArrow = new RightArrowButton((int) (widthRatio*(x+240)), (int) (heightRatio*(y)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        rightArrow.addActionListener((ActionEvent evt) -> {
            GregorianCalendar tempCalendar = new GregorianCalendar();
            tempCalendar.setTime(buttons[5][0].getDate());
            if(tempCalendar.get(GregorianCalendar.DAY_OF_MONTH) < 9 && tempCalendar.get(GregorianCalendar.DAY_OF_MONTH) != 1) tempCalendar.setTime(buttons[4][0].getDate());
            tempCalendar.setFirstDayOfWeek(GregorianCalendar.MONDAY);
            for (CalendarButton[] week : buttons) {
                for (CalendarButton day : week) {
                    day.set(tempCalendar);
                    tempCalendar.roll(GregorianCalendar.DAY_OF_YEAR, true);
                    if(tempCalendar.get(GregorianCalendar.DAY_OF_YEAR) == 1) tempCalendar.roll(GregorianCalendar.YEAR, true);
                }
            }
            if(tempCalendar.get(GregorianCalendar.MONTH) == 0)
            {
                month.setText(MONTHS[11]+" "+(tempCalendar.get(GregorianCalendar.YEAR)-1));
            }
            else month.setText(MONTHS[tempCalendar.get(GregorianCalendar.MONTH)-1]+" "+tempCalendar.get(GregorianCalendar.YEAR));
        });
        
        
        leftArrow = new LeftArrowButton((int) (widthRatio*(x+48)), (int) (heightRatio*(y)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        leftArrow.addActionListener((ActionEvent evt) -> {
            GregorianCalendar tempCalendar = new GregorianCalendar();
            tempCalendar.setTime(buttons[0][0].getDate());
            if(tempCalendar.get(GregorianCalendar.DAY_OF_MONTH) < 30 && tempCalendar.get(GregorianCalendar.DAY_OF_MONTH) > 1) tempCalendar.setTime(buttons[1][6].getDate());
            else tempCalendar.setTime(buttons[0][6].getDate());
            tempCalendar.setFirstDayOfWeek(GregorianCalendar.MONDAY);
            for(int i = buttons.length - 1; i > -1 ; i--) {
                for(int j = buttons[i].length - 1; j > -1 ; j--) {
                    buttons[i][j].set(tempCalendar);
                    
                    if(tempCalendar.get(GregorianCalendar.DAY_OF_YEAR) == 1) 
                    {
                        tempCalendar.roll(GregorianCalendar.YEAR, false);
                        if(tempCalendar.isLeapYear(tempCalendar.get(GregorianCalendar.YEAR)))
                        {
                            tempCalendar.set(GregorianCalendar.DAY_OF_YEAR, 365);
                            tempCalendar.set(GregorianCalendar.MONTH, 11);
                            tempCalendar.set(GregorianCalendar.DATE, 31);
                        }
                        else 
                        {
                            tempCalendar.set(GregorianCalendar.DAY_OF_YEAR, 364);
                            tempCalendar.set(GregorianCalendar.MONTH, 11);
                            tempCalendar.set(GregorianCalendar.DATE, 31);
                        }
                    }
                    else tempCalendar.roll(GregorianCalendar.DAY_OF_YEAR, false);
                }
            }
            if(tempCalendar.get(GregorianCalendar.DAY_OF_MONTH) > 7)
            {
                tempCalendar.roll(GregorianCalendar.DAY_OF_YEAR, 15);
                if(tempCalendar.get(GregorianCalendar.MONTH) == 0) month.setText(MONTHS[tempCalendar.get(GregorianCalendar.MONTH)]+" "+(tempCalendar.get(GregorianCalendar.YEAR)+1));
                else month.setText(MONTHS[tempCalendar.get(GregorianCalendar.MONTH)]+" "+tempCalendar.get(GregorianCalendar.YEAR));
            }
            else month.setText(MONTHS[tempCalendar.get(GregorianCalendar.MONTH)]+" "+tempCalendar.get(GregorianCalendar.YEAR));
        });
        
        month = new JLabel();
        month.setText(MONTHS[calendar.get(GregorianCalendar.MONTH)]+" "+calendar.get(GregorianCalendar.YEAR));
        month.setBounds((int) (widthRatio*(x+80)), (int) (heightRatio*(y+4)), (int) (widthRatio*(160)), (int) (heightRatio*(24)));
        month.setFont(new Font("Arial", Font.PLAIN, 20));
        month.setForeground(AppWindow.OFF_WHITE);
        month.setHorizontalAlignment(JLabel.CENTER);
        month.setVerticalAlignment(JLabel.CENTER);
        
        int todayWeekOfMonth = calendar.get(GregorianCalendar.WEEK_OF_MONTH);
        int todayDayOfWeek = (calendar.get(GregorianCalendar.DAY_OF_WEEK)+6)%7;
        if(todayDayOfWeek == 0) todayDayOfWeek = 7;
        calendar.roll(GregorianCalendar.DAY_OF_YEAR, -((todayWeekOfMonth-1)*7 + todayDayOfWeek-1));
        buttons = new CalendarButton[6][7];
        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++)
            {
                buttons[i][j] = new CalendarButton(calendar, (int) (widthRatio*(j*48+x)), (int) (heightRatio*(i*48+83+y)), (int) (widthRatio*(32)), (int) (heightRatio*(32)), (int) (heightRatio*16));
                buttons[i][j].addActionListener((ActionEvent evt) -> {
                    CalendarButton source = (CalendarButton) evt.getSource();
                    this.selectedCalendar.onClick();
                    source.onClick();
                    this.selectedCalendar = source;
                });
                calendar.roll(GregorianCalendar.DAY_OF_YEAR, true);
            }
        }
        
        selectedCalendar = buttons[todayWeekOfMonth-1][todayDayOfWeek-1];
        selectedCalendar.onClick();
        
        monday = new JLabel("M");
        monday.setForeground(AppWindow.OFF_WHITE);
        monday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*(16))));
        monday.setHorizontalAlignment(JLabel.CENTER);
        monday.setVerticalAlignment(JLabel.CENTER);
        monday.setBounds((int) (widthRatio*(x)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        
        tuesday = new JLabel("T");
        tuesday.setForeground(AppWindow.OFF_WHITE);
        tuesday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*(16))));
        tuesday.setHorizontalAlignment(JLabel.CENTER);
        tuesday.setVerticalAlignment(JLabel.CENTER);
        tuesday.setBounds((int) (widthRatio*(x+48)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        
        wednesday = new JLabel("W");
        wednesday.setForeground(AppWindow.OFF_WHITE);
        wednesday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*(16))));
        wednesday.setHorizontalAlignment(JLabel.CENTER);
        wednesday.setVerticalAlignment(JLabel.CENTER);
        wednesday.setBounds((int) (widthRatio*(x+96)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        
        thursday = new JLabel("T");
        thursday.setForeground(AppWindow.OFF_WHITE);
        thursday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*(16))));
        thursday.setHorizontalAlignment(JLabel.CENTER);
        thursday.setVerticalAlignment(JLabel.CENTER);
        thursday.setBounds((int) (widthRatio*(x+144)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        
        friday = new JLabel("F");
        friday.setForeground(AppWindow.OFF_WHITE);
        friday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*(16))));
        friday.setHorizontalAlignment(JLabel.CENTER);
        friday.setVerticalAlignment(JLabel.CENTER);
        friday.setBounds((int) (widthRatio*(x+192)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        
        saturday = new JLabel("S");
        saturday.setForeground(AppWindow.OFF_WHITE);
        saturday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*(16))));
        saturday.setHorizontalAlignment(JLabel.CENTER);
        saturday.setVerticalAlignment(JLabel.CENTER);
        saturday.setBounds((int) (widthRatio*(x+240)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
        
        sunday = new JLabel("S");
        sunday.setForeground(AppWindow.OFF_WHITE);
        sunday.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*16)));
        sunday.setHorizontalAlignment(JLabel.CENTER);
        sunday.setVerticalAlignment(JLabel.CENTER);
        sunday.setBounds((int) (widthRatio*(x+288)), (int) (heightRatio*(y+42)), (int) (widthRatio*(32)), (int) (heightRatio*(32)));
    }
    
    public Date getSelectedDate()
    {
        return selectedCalendar.getDate();
    }
    
    public void addToLayeredPane(JLayeredPane layeredPane)
    {
        layeredPane.add(rightArrow);
        layeredPane.add(leftArrow);
        layeredPane.add(month);
        for(CalendarButton[] week : buttons)
        {
            for(CalendarButton day : week)
            {
                layeredPane.add(day);
            }
        }
        layeredPane.add(monday);
        layeredPane.add(tuesday);
        layeredPane.add(wednesday);
        layeredPane.add(thursday);
        layeredPane.add(friday);
        layeredPane.add(saturday);
        layeredPane.add(sunday);
    }
    
    public void removeFromLayeredPane(JLayeredPane layeredPane)
    {
        layeredPane.remove(rightArrow);
        layeredPane.remove(leftArrow);
        layeredPane.remove(month);
        for(CalendarButton[] week : buttons)
        {
            for(CalendarButton day : week)
            {
                layeredPane.remove(day);
            }
        }
        layeredPane.remove(monday);
        layeredPane.remove(tuesday);
        layeredPane.remove(wednesday);
        layeredPane.remove(thursday);
        layeredPane.remove(friday);
        layeredPane.remove(saturday);
        layeredPane.remove(sunday);
    }
    
    public void setVisible(boolean visible)
    {
        rightArrow.setVisible(visible);
        leftArrow.setVisible(visible);
        month.setVisible(visible);
        for(CalendarButton[] week : buttons)
        {
            for(CalendarButton day : week)
            {
                day.setVisible(visible);
            }
        }
        monday.setVisible(visible);
        tuesday.setVisible(visible);
        wednesday.setVisible(visible);
        thursday.setVisible(visible);
        friday.setVisible(visible);
        saturday.setVisible(visible);
        sunday.setVisible(visible);
    }
}

class CalendarButton extends JButton {
    
    private Date date;
    private boolean selected;
    
    public CalendarButton(GregorianCalendar calendar, int x, int y, int width, int height, int fontSize)
    {
        super();
        
        selected = false;
        
        date = calendar.getTime();
        
        setText(Integer.toString(calendar.get(GregorianCalendar.DAY_OF_MONTH)));
        setFont(new Font("Arial", Font.BOLD, fontSize));
        setBackground(AppWindow.OFF_WHITE);
        setForeground(AppWindow.EERIE_BLACK);
        setBounds(x, y, width, height);
        setMargin(new Insets(0, 0, 0, 0));
        setHorizontalTextPosition(JLabel.CENTER);
        setBorder(BorderFactory.createLineBorder(AppWindow.EERIE_BLACK, 3));
    }

    public Date getDate() {
        return date;
    }
    
    public void set(GregorianCalendar calendar)
    {
        date = calendar.getTime();
        
        setText(Integer.toString(calendar.get(GregorianCalendar.DAY_OF_MONTH)));
    }
    
    public void onClick()
    {
        selected = !selected;
        selected();
    }
    
    private void selected()
    {
        if(selected) 
        {
            setBackground(AppWindow.CARROT_ORANGE);
            setForeground(Color.WHITE);
        }
        else
        {
            setBackground(AppWindow.OFF_WHITE);
            setForeground(AppWindow.EERIE_BLACK);
        }
    }
}