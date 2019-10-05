package com.example.ad37_nguyenquyton_day07;

public class Contact {
    String name;
    String noidung;
    boolean seen;
    String haicham;
    boolean icon;
    public boolean isIcon() {
        return icon;
    }

    public void setIcon(boolean icon) {
        this.icon = icon;
    }



    public Contact(String name, String noidung, boolean seen) {
        this.name = name;
        this.noidung = noidung;
        this.seen = seen;
    }

    public void setHaicham(String haicham) {
        this.haicham = ":";
    }
    public String getHaicham() {
        return haicham;
    }
    public String getName() {
        return name;
    }

    public String getNoidung() {
        return noidung;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
