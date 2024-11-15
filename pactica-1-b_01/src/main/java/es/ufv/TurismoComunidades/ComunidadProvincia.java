package es.ufv.TurismoComunidades;

import java.util.Objects;

public class ComunidadProvincia {
    private String comunidad;
    private String provincia;

    public ComunidadProvincia(String comunidad, String provincia) {
        this.comunidad = comunidad;
        this.provincia = provincia;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComunidadProvincia that = (ComunidadProvincia) o;
        return comunidad.equals(that.comunidad) && provincia.equals(that.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comunidad, provincia);
    }

}
