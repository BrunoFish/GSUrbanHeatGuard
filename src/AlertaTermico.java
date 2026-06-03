import java.time.LocalDate;

public class AlertaTermico {

    private int idAlerta;
    private Sensor sensor; // A FK apontando de volta para o Sensor
    private double temperaturaRegistrada;
    private String nivelSeveridade;
    private LocalDate dataAlerta;

    // Construtor vazio
    public AlertaTermico() {
    }

    // Construtor completo
    public AlertaTermico(int idAlerta, Sensor sensor, double temperaturaRegistrada, String nivelSeveridade, LocalDate dataAlerta) {
        this.idAlerta = idAlerta;
        this.sensor = sensor;
        this.temperaturaRegistrada = temperaturaRegistrada;
        this.nivelSeveridade = nivelSeveridade;
        this.dataAlerta = dataAlerta;
    }

    // Getters e Setters
    public int getIdAlerta() { return idAlerta; }
    public void setIdAlerta(int idAlerta) { this.idAlerta = idAlerta; }

    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }

    public double getTemperaturaRegistrada() { return temperaturaRegistrada; }
    public void setTemperaturaRegistrada(double temperaturaRegistrada) { this.temperaturaRegistrada = temperaturaRegistrada; }

    public String getNivelSeveridade() { return nivelSeveridade; }
    public void setNivelSeveridade(String nivelSeveridade) { this.nivelSeveridade = nivelSeveridade; }

    public LocalDate getDataAlerta() { return dataAlerta; }
    public void setDataAlerta(LocalDate dataAlerta) { this.dataAlerta = dataAlerta; }

    @Override
    public String toString() {
        return "Alerta #" + idAlerta + " | Temp: " + temperaturaRegistrada + "°C | Nível: " + nivelSeveridade + " | Data: " + dataAlerta;
    }
}