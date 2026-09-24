package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_template", nullable = false)
    private Boolean isTemplate;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_repo_id")
    private Repository parentRepository;

    @JsonIgnore
    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL)
    private List<Commit> commits;

    @JsonIgnore
    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL)
    private List<PullRequest> pullRequests;
}
