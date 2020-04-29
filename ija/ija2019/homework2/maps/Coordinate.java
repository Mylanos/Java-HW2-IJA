/*
 * Soubor: Coordinate.java
 * Ukol c. 2
 * Autor: Marek Ziska, xziska03@stud.fit.vutbr.cz
 * Skupina: 2BIB
 * Datum 02.04.2020
 */

package ija.ija2019.homework2.maps;

/**
 * Reprezentuje pozici (souřadnice) v mapě. Souřadnice je dvojice (x,y), počátek mapy je vždy
 * na pozici (0,0). Nelze mít pozici se zápornou souřadnicí.
 */
public class Coordinate {
    private int x;
    private int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Vytvoří instanci Coordinate podle zadaných parametrů.
     * @param x souřadnice x
     * @param y souřadnice y
     * @return Vytvořený objekt Coordinate. Pokud souřadnice nevyhovují podmínce objektu, vrací null.
     */
    public static Coordinate create(int x, int y) {
        if (x < 0 || y < 0) {
            return null;
        }
        return new Coordinate(x, y);
    }

    /**
     * Vrací hodnotu souřadnice x.
     * @return souřadnice x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Vrací hodnotu souřadnice y.
     * @return souřadnice y
     */
    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        return ((Coordinate) obj).getX() == this.getX() && ((Coordinate) obj).getY() == this.getY();
    }

    /**
     * Vypočíta vzdialenosť medzi dvoma súradnicami.
     * @return Vzdialenosť dvoch bodov.
     */
    public double getDistance(Coordinate c) {
        return Math.sqrt((this.diffY(c)) * (this.diffY(c)) + (this.diffX(c)) * (this.diffX(c)));
    }

    /**
     * Vrací rozdíl souřadnic X : this.x - c.x.
     * @param c Porovnávaná pozice
     * @return Rozdíl hodnot souřadnic X.
     */
    public int diffX(Coordinate c){
        return this.x - c.getX();
    }

    /**
     * Vrací rozdíl souřadnic Y : this.y - c.y.
     * @param c Porovnávaná pozice
     * @return Rozdíl hodnot souřadnic Y.
     */
    public int diffY(Coordinate c) {
        return this.y - c.getY();
    }


}
