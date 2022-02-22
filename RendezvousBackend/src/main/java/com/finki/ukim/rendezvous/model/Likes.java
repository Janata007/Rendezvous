package com.finki.ukim.rendezvous.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "main_user_id")
    private long mainUserId;
    @Column(name = "liked_user_id")
    private long likedUserId;
    @Column(name = "is_liked")
    private Boolean isLiked;
    @Column(name = "is_plus_ultra_liked")
    private Boolean isPlusUltraLiked;
    public Likes(long mainUserId, long likedUserId, boolean isLiked, boolean isPlusUltraLiked){
        this.mainUserId = mainUserId;
        this.likedUserId = likedUserId;
        this.isLiked = isLiked;
        this.isPlusUltraLiked = isPlusUltraLiked;
    }
}
