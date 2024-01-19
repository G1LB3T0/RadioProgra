public class Radio {
    boolean power;
    float emisora;
    boolean frecuencia;

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public float getEmisora() {
        return emisora;
    }

    public void setEmisora(float emisora) {
        this.emisora = emisora;
    }

    public boolean isFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(boolean frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Radio() {
    }

    public Radio(boolean power, float emisora, boolean frecuencia) {
        this.power = power;
        this.emisora = emisora;
        this.frecuencia = frecuencia;
    }
}
