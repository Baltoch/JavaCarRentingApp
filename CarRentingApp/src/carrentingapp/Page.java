/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public abstract class Page {
    public Page prev;
    public Page next;
    protected AppWindow window;
    
    public Page(AppWindow window)
    {
        this.window = window;
    }
    public abstract void addToLayeredPane();
    public abstract void removeFromLayeredPane();
    public abstract void setVisible(boolean visible);
}
