package com.hello.capston.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "likes")
public class Likes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private String recommend;

    private String size;

    public Likes(Member member, User user, Item item, String recommend, String size) {
        this.member = member;
        this.user = user;
        this.item = item;
        this.recommend = recommend;
        this.size = size;
    }

    public Likes(Long id, Member member, User user, Item item, String recommend, String size) {
        this.id = id;
        this.member = member;
        this.user = user;
        this.item = item;
        this.recommend = recommend;
        this.size = size;
    }
}
