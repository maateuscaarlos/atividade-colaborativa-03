package br.edu.ifpb.dac.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Banda_integrante implements Serializable {
    @Id
    private int bandaId;
    @Id
    private int IntegranteId;

    public Banda_integrante(int bandaId, int integranteId) {
        this.bandaId = bandaId;
        IntegranteId = integranteId;
    }

    public Banda_integrante() {
    }

    public int getBandaId() {
        return bandaId;
    }

    public void setBandaId(int bandaId) {
        this.bandaId = bandaId;
    }

    public int getIntegranteId() {
        return IntegranteId;
    }

    public void setIntegranteId(int integranteId) {
        IntegranteId = integranteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banda_integrante)) return false;
        Banda_integrante that = (Banda_integrante) o;
        return getBandaId() == that.getBandaId() && getIntegranteId() == that.getIntegranteId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBandaId(), getIntegranteId());
    }
}
