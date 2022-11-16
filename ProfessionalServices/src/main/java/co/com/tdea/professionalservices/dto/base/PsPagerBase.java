package co.com.tdea.professionalservices.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PsPagerBase implements Serializable {
    long total;
    long offset;
    long size;
}