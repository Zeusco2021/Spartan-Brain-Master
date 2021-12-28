
package com.spartan.spartanbrain.domain.model.student;

import javax.persistence.*;

import com.spartan.spartanbrain.domain.model.country.Country;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.spartan.spartanbrain.domain.shared.AbstractSharedEntity;


@Slf4j
@EqualsAndHashCode(callSuper = false)
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Cacheable(false)
@Table(name = "SPTN_SPAPI_STUDENT",
        indexes = {@Index(name = "OALCN_SPI_CUSTOMER_U1", columnList = "CUSTOMER_ID", unique = true),
                @Index(name = "OALCN_SPI_CUSTOMER_U2", columnList = "SDD_KEY_ID, TENANT_CODE", unique = true)})
public final class Student extends AbstractSharedEntity<Student> {
    @Id
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    @SequenceGenerator(name = "OALCN_SPI_SEQ", sequenceName = "OALCN_SPI_SEQ", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OALCN_SPI_SEQ")
    private Long studentId;

    @Column(name = "TENANT_CODE", length = 100, nullable = false)
    private String tenantCode;

    @Column(name = "SDD_KEY_ID", length = 240, nullable = false)
    private String sddKeyId;

    @Column(name = "STUDENT_NAME", length = 240, nullable = false)
    private String studentName;

    @Column(name = "STUDENT_FIRST_NAME", length = 240, nullable = false)
    private String studentFirstName;

    @Column(name = "STUDENT_LAST_NAME", length = 240, nullable = false)
    private String studentLastName;

    @Column(name = "STUDENT_ADDRESS1", length = 500)
    private String studentAddress;

    @Column(name = "CITY", length = 500)
    private String customerCity;

    @Column(name = "STATE", length = 500)
    private String customerState;

    @Column(name = "COUNTY", length = 500)
    private String customerCounty;

    @Column(name = "STATE", length = 500)
    private String customerProvince;

    @Column(name = "POSTAL_CODE", length = 500)
    private String customerPostalCode;

    @Column(name = "COUNTRY", length = 500)
    private String customerCountry;

    @Column(name = "CORRELATION_ID", length = 240, nullable = false)
    private String correlationId;

    @Column(name = "NICK_NAME", length = 100, nullable = false)
    private String nickName;

    @Column(name = "SOURCE", length = 240)
    private String source;

    @Column(name = "ACCOUNT_NUMBER", length = 500, nullable = true)
    private String accountNumber;

    private static final String EMPTY_STRING = "";

    @OneToOne
    @Column (name= "COUNTRY_ID")
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

    /** {@inheritDoc} */
    @Override
    @Generated
    public boolean sameIdentityAs(Student other) {
        //return other != null && new EqualsBuilder().append(this, other).isEquals();
        return true;

    }

    /** {@inheritDoc} */
    @Override
    public boolean merge(Student other) {
        log.debug("Change number this:{} - Change number other:{}", this.getChangeNumber(), other.getChangeNumber());
        if (other.getChangeNumber() > this.getChangeNumber()) {
            this.setChangeNumber(other.getChangeNumber());

            if (!this.sameIdentityAs(other)) {

                this.correlationId = other.correlationId;

                this.customerCountry = other.customerCountry;
                this.customerCounty = other.customerCounty;

                this.customerProvince = other.customerProvince;
                this.customerPostalCode = other.customerPostalCode;
                this.setChangeNumber(other.getChangeNumber());

            }
            return true;
        }
        return false;
    }

    /**
     * @param builder builder
     *
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
         *
         * @param changeNumber changeNumber
         * @return customer buid
         */
        public EmployeeBuilder changeNumber(long changeNumber) {
            this.changeNumber = changeNumber;
            return this;
        }
    }
}
