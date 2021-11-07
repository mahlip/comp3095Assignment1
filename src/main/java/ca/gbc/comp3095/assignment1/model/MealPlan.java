package ca.gbc.comp3095.assignment1.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="MEAL")
public class MealPlan{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MEAL_ID")
    private Long id;

    @Column(name="Name", nullable = false)
    private String name;

    @Column(name ="Date", nullable = false)
    private String date;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER_ID")
    private AppUser owner;

    @Column(name ="PUBLIC")
    private boolean shared;


    public MealPlan(String name,
                  String date,
                  AppUser user) {
        //super();
        this.name = name;
        this.date = date;
        this.shared = shared;
        this.owner = user;
    }

    public MealPlan() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeal() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.name = date;
    }

    public AppUser getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public boolean isShared() {
        return shared;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}

