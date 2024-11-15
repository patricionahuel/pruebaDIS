package es.ufv.TurismoComunidades;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class TurismoData {

    private String id;
    private ComunidadProvincia origen;
    private ComunidadProvincia destino;
    private Periodo periodo;
    private int total;

    public TurismoData(ComunidadProvincia origen, ComunidadProvincia destino, Periodo periodo, int total) {
        this.id = UUID.randomUUID().toString();
        this.origen = origen;
        this.destino = destino;
        this.periodo = periodo;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ComunidadProvincia getOrigen() {
        return origen;
    }

    public void setOrigen(ComunidadProvincia origen) {
        this.origen = origen;
    }

    public ComunidadProvincia getDestino() {
        return destino;
    }

    public void setDestino(ComunidadProvincia destino) {
        this.destino = destino;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurismoData that = (TurismoData) o;
        return id == that.id && total == that.total && origen.equals(that.origen) && destino.equals(that.destino) && periodo.equals(that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origen, destino, periodo, total);
    }

    @Override
    public String toString() {
        return "TurismoFromJson{" +
                "id=" + id +
                ", origen=" + origen +
                ", destino=" + destino +
                ", periodo=" + periodo +
                ", total=" + total +
                '}';
    }

    public static TurismoData parserCsv (String linea) throws IOException {
        try{
            String [] partes = linea.split(";");
            partes[7]=partes[7].replace(",","");
            ComunidadProvincia origen = new ComunidadProvincia(partes[0],partes[1]);
            ComunidadProvincia destino = new ComunidadProvincia(partes[3],partes[4]);
            Periodo periodo = new Periodo(partes[6]);
            int total = Integer.parseInt(partes[7].replace(",",""));
            TurismoData turismoData = new TurismoData(origen,destino,periodo,total);
            return turismoData;
        }

        catch (Exception e){
            System.err.println("Error en linea:"+ linea);
            //System.in.read();
            return null;

        }
    }
}
