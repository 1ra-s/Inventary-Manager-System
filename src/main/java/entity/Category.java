package entity;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
public class Category {


    public Category(Long id) {
        this.id = id;
    }

    public Category() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatetAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdatetAt() {
        return updatetAt;
    }

    public void setUpdatetAt(LocalDateTime updatetAt) {
        this.updatetAt = updatetAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                ", updatetAt=" + updatetAt +
                '}';
    }
}
