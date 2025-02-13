package vn_phuocloc.phuocloc_sample_code.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

//@Data = @Getter + @Setter + @EqualAndHashCode + @ToString
@Getter
public class SampleDTO implements Serializable {
    private Integer id;
    private String name;

}
