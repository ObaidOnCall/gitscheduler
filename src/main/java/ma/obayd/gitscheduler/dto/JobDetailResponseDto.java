package ma.obayd.gitscheduler.dto;

import java.util.Date;
import java.util.List;

import org.quartz.JobKey;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @JsonFilter("dynamicFilter")
@Data @Setter @Getter @Builder
public class JobDetailResponseDto implements Response{

    private String description ;
    private Date nextFirTime ;
    private boolean isCreated ;
    private int errCode ;
    private String errMessage ;
    private JobKey jobKey ;


    // public static MappingJacksonValue selectiveFields (List<String> fields , JobDetailResponseDto jobObject) {

    //     MappingJacksonValue mapping = new MappingJacksonValue(jobObject) ;

    //     if (fields != null && !fields.isEmpty()) {
    //         SimpleFilterProvider filterProvider = new SimpleFilterProvider()
    //                 .addFilter("dynamicFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields.toArray(new String[0])));
    //         mapping.setFilters(filterProvider);
    //     }
    //     else {
    //         SimpleFilterProvider filterProvider = new SimpleFilterProvider()
    //             .addFilter("dynamicFilter", SimpleBeanPropertyFilter.serializeAll());
    //         mapping.setFilters(filterProvider);
    //     }

    //     return mapping ;
    // }
}
