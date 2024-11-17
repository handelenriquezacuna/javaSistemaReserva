/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sistemareservajava;

/**
 *
 * @author hande
 */
public enum EnumMenu {
    CAFE_NORMAL,
    CAPUCHINO,
    CAPUCHINO_VAINILLA,
    CHOCOLATE,
    MOKA,
    TE_CHAI,
    CAFE_FRIO;

    @Override
    public String toString() {
        return "EnumMenu{" + "ordinal=" + ordinal() + ", name=" + name() + '}';
    }

    public static EnumMenu getCAFE_NORMAL() {
        return CAFE_NORMAL;
    }

    public static EnumMenu getCAPUCHINO() {
        return CAPUCHINO;
    }

    public static EnumMenu getCAPUCHINO_VAINILLA() {
        return CAPUCHINO_VAINILLA;
    }

    public static EnumMenu getCHOCOLATE() {
        return CHOCOLATE;
    }

    public static EnumMenu getMOKA() {
        return MOKA;
    }

    public static EnumMenu getTE_CHAI() {
        return TE_CHAI;
    }

    public static EnumMenu getCAFE_FRIO() {
        return CAFE_FRIO;
    }
    
}
