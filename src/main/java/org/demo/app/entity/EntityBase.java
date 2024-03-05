package org.demo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdBy", "lastModifiedBy", "deletedBy"}
)
@EntityListeners({EntityListeners.class})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "last_modified_at")
    private Timestamp lastModifiedAt;
    //@CreatedBy
    @Column(name = "created_by")
    private String createdBy;
    //@LastModifiedBy
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;
    @Column(name = "deleted_by")
    private Long deletedBy;

}
