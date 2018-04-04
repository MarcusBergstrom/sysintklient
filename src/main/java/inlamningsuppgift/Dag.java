
package inlamningsuppgift;


import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Dagar")


public class Dag implements Serializable {
    private static final long serialVersionUID = 1L;
    private int elforbrukning;
    private int temp;
    private int belysning;
    private int luftfuktighet;
    private Date date;
    
    public Dag() {}
    
    public Dag(int elforbrukning, int temp, int belysning, int luftfuktighet, Date date){
    this.belysning = belysning;
    this.temp = temp;
    this.luftfuktighet = luftfuktighet;
    this.elforbrukning = elforbrukning;
    this.date = date;
   
    
    }//Kompisklass

    public Dag(int i, String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getElforbrukning() {
        return elforbrukning;
    }

   
    @XmlElement
    public void setElforbrukning(int elforbrukning) {
        this.elforbrukning = elforbrukning;
    }

    
    public int getTemp() {
        return temp;
    }

   
    @XmlElement
    public void setTemp(int temp) {
        this.temp = temp;
    }

    
    public int getBelysning() {
        return belysning;
    }

    
    @XmlElement
    public void setBelysning(int belysning) {
        this.belysning = belysning;
    }

   
    public int getLuftfuktighet() {
        return luftfuktighet;
    }

 
    @XmlElement
    public void setLuftfuktighet(int luftfuktighet) {
        this.luftfuktighet = luftfuktighet;
    }

 
    public Date getDate() {
        return date;
    }

    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }
    
}
