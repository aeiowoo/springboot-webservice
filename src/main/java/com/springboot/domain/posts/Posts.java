package com.springboot.domain.posts;

import com.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id     // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // GenerationType.IDENTITY 으로 설정해야 auto_increment
    private Long id;

    @Column(length = 500, nullable = false)     // 테이블 컬럼 어노테이션, 해당 어노테이션 사용하지 않아도 클래스의 필드는 모두 컬럼이지만, 옵션 설정 시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder        // 생성자 상단에 해당 어노테이션 사용 시, 생성자에 포함된 필드만 빌더에 포함됨
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
