package application.classes;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "films")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "filmName")
    private String filmName;

    @Column(name = "prod")
    private String prod;

    @Column(name = "company")
    private String company;

    @Column(name = "year")
    private String year;

    @Column(name = "rating")
    private String rating;

    public Record() {
    }

    public Record(String filmName, String prod, String company, String year, String rating) {
        this.filmName = filmName;
        this.prod = prod;
        this.company = company;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", filmName='" + filmName + '\'' +
                ", prod='" + prod + '\'' +
                ", company='" + company + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public String[] toStringArray(){
        String[] array = new String[6];
        array[0] = String.valueOf(id) ;
        array[1] = filmName;
        array[2] = prod;
        array[3] = company;
        array[4] = year;
        array[5] = rating;
        return array;
    }
}
