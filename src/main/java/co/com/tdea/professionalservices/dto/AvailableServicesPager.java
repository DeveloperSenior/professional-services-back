package co.com.tdea.professionalservices.dto;

import co.com.tdea.professionalservices.dto.base.PsPagerBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class AvailableServicesPager extends PsPagerBase {

    List<ServiciosDisponibles> availableServices;
    ServiciosDisponibles filter;
}
