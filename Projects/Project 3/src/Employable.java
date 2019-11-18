import java.math.BigDecimal;

/**
 * @author varun
 * @version 1.0
 */
public interface Employable {
    BigDecimal getHourlyWage();

    void setHourlyWage(BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException;
}
