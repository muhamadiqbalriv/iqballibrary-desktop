/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MUSASHI NAGASAKI
 */
public class ComboItem {
    private Object value;
    private Object label;

    public ComboItem(Object value, Object label) {
        this.value = value;
        this.label = label;
    }

    public Object getValue() {
        return this.value;
    }

    public Object getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label.toString();
    }
}
