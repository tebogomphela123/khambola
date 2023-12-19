package tebogo.khula.khambola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name =  "Image")
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
