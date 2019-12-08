package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;

@Entity
@Table(name="result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @OneToOne(mappedBy = "result", cascade = CascadeType.ALL)
    private Math match;

    @Column(name = "is_dead_heat")
    private boolean isDeadHeat;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team winner;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team defeated;
}