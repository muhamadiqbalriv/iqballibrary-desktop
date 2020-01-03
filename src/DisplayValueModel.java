/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MUSASHI NAGASAKI
 */
public class DisplayValueModel {
    public Object displayMember;
    public Object valueMember;

    public DisplayValueModel(Object display, Object value) {
        displayMember = display;
        valueMember = value;
    }

    public String toString() {
        return displayMember.toString();
    }
    @Override
        public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((valueMember == null) ? 0 : valueMember.hashCode());
        result = prime * result + ((displayMember == null) ? 0 : displayMember.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DisplayValueModel other = (DisplayValueModel) obj;
        if (displayMember == null) {
            if (other.displayMember != null)
                return false;
        } else if (!displayMember.equals(other.displayMember))
            return false;
        if (valueMember == null) {
            if (other.valueMember != null)
                return false;
        } else if (!valueMember.equals(other.valueMember))
            return false;
        return true;
    }
}
