
package com.spartan.spartanbrain.domain.model.student;

import com.spartan.spartanbrain.domain.model.country.Country;
import com.spartan.spartanbrain.domain.model.language.Language;
import com.spartan.spartanbrain.domain.shared.AbstractSharedEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;


@Slf4j
@EqualsAndHashCode(callSuper = false)
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Cacheable(false)
@Table(name = "SPTN_SPAPI_STUDENT",
        indexes = {@Index(name = "OALCN_SPI_STUDENT_ID_U1", columnList = "STUDENT_ID", unique = true)})
public final class Student extends AbstractSharedEntity<Student> {
    @Id
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    @SequenceGenerator(name = "OALCN_SPI_SEQ", sequenceName = "OALCN_SPI_SEQ", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OALCN_SPI_SEQ")
    private Long studentId;

    @Column(name = "STUDENT_NAME", length = 240, nullable = false)
    private String studentName;

    @Column(name = "STUDENT_FIRST_NAME", length = 240, nullable = false)
    private String studentFirstName;

    @Column(name = "STUDENT_LAST_NAME", length = 240, nullable = false)
    private String studentLastName;

    @Column(name = "STUDENT_EMAIL", length = 500)
    private String studentEmail;

    @Column(name = "STATE", length = 500)
    private String studentState;

    @Column(name = "POSTAL_CODE", length = 500)
    private String studentPostalCode;

    @Column(name = "CORRELATION_ID", length = 240, nullable = false)
    private String correlationId;

    @Column(name = "NICK_NAME", length = 100, nullable = false)
    private String nickName;

    private static final String EMPTY_STRING = "";

    /************************************** Entities Relations section **************************************/

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID", insertable = false,
                    updatable = false)})
    @Getter
    private Language language;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable = false,
                    updatable = false)})
    private Country countryId;

    /**
     * Method that Builds the customer address from: customerAddress1 + customerAddress2 + customerAddress3
     *
     * @param student Customer
     * @return Customer Address
     */
    public String processCustomerAddress(Student student) {

        StringBuilder customerAddress = new StringBuilder();

        //String customerAddressLine1 = Optional.ofNullable(employee.getCustomerAddress1()).orElse(EMPTY_STRING);


        //customerAddress.append(customerAddressLine1);
        // customerAddress.append(" ");


        return customerAddress.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Generated
    public boolean sameIdentityAs(Student other) {
        return other != null && new EqualsBuilder().append(this, other).isEquals();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean merge(Student other) {
        log.debug("Change number this:{} - Change number other:{}", this.getChangeNumber(), other.getChangeNumber());
        if (other.getChangeNumber() > this.getChangeNumber()) {
            this.setChangeNumber(other.getChangeNumber());

            if (!this.sameIdentityAs(other)) {
                this.correlationId = other.correlationId;
                this.setChangeNumber(other.getChangeNumber());
            }
            return true;
        }
        return false;
    }

    /**
     * @param builder builder
     */
    @Generated
    private Student(EmployeeBuilder builder) {

        //customerId = builder.customerId;
        // setChangeNumber(builder.changeNumber);

    }

    /**
     * @author
     */
    @Generated
    public static class EmployeeBuilder {

        private long changeNumber;

        /**
         * @return Customer build
         */
        public Student build() {
            return new Student(this);
        }

        /**
         * @param changeNumber changeNumber
         * @return customer buid
         */
        public EmployeeBuilder changeNumber(long changeNumber) {
            this.changeNumber = changeNumber;
            return this;
        }
    }
}
