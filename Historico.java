package trabalho_04_09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Luan Gomes
 */
public class Historico {
    
    private Date data;
    private double peso;
    private short altura;
    private double temeratura;
    public SimpleDateFormat format;
    
    public Historico() {
        format = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public Date getData() {
        return data;
    }

    public Historico setData(String data) throws ParseException {
        this.data = this.format.parse(data);
        return this;
    }

    public double getPeso() {
        return peso;
    }

    public Historico setPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public short getAltura() {
        return altura;
    }

    public Historico setAltura(short altura) {
        this.altura = altura;
        return this;
    }

    public double getTemeratura() {
        return temeratura;
    }

    public Historico setTemeratura(double temeratura) {
        this.temeratura = temeratura;
        return this;
    }
    
}
