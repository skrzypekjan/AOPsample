package pl.skrzypekjan.aopsample.model;
import static pl.skrzypekjan.aopsample.service.FilmServiceImpl.count;

public class Film {

    private long id;
    private String name;
    private String producer;
    private int year;

    public Film(String name, String producer, int year) {
        this.id = count;
        this.name = name;
        this.producer = producer;
        this.year = year;
        count++;
    }

    public Film() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", year=" + year +
                '}';
    }
}
