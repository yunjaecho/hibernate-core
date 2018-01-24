package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 2018-01-22.
 */

@Entity
@Data
@Table(name = "TIME_TEST")
public class TimeTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_TEST_ID")
    private Long timeTestId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_COLUMN")
    private Date datatimeColumn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP_COLUMN")
    private Date timestampColumn;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COLUMN")
    private Date dateColumn;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_COLUMN")
    private Date timeColumn;

    @Column(name = "SQL_DATETIME_COLUMN")
    private java.sql.Timestamp sqlDatetimeColumn;

    @Column(name = "SQL_TIMESTAMP_COLUMN")
    private java.sql.Timestamp sqlTimestampColumn;

    @Column(name = "SQL_DATE_COLUMN")
    private java.sql.Date sqlDateColumn;

    @Column(name = "SQL_TIME_COLUMN")
    private java.sql.Time sqlTimeColumn;

    public TimeTest(Date date) {
        this.datatimeColumn = date;
        this.timestampColumn = date;
        this.timeColumn = date;
        this.dateColumn = date;

        this.sqlDatetimeColumn = new java.sql.Timestamp(date.getTime());
        this.sqlTimestampColumn = new java.sql.Timestamp(date.getTime());
        this.sqlDateColumn = new java.sql.Date(date.getTime());
        this.sqlTimeColumn = new java.sql.Time(date.getTime());
    }

    public TimeTest() {
    }

    @Override
    public String toString() {
        return "\nTimeTest{" +
                "\ntimeTestId=" + timeTestId +
                "\n, datatimeColumn=" + datatimeColumn +
                "\n, timestampColumn=" + timestampColumn +
                "\n, dateColumn=" + dateColumn +
                "\n, timeColumn=" + timeColumn +
                "\n, sqlDatetimeColumn=" + sqlDatetimeColumn +
                "\n, sqlTimestampColumn=" + sqlTimestampColumn +
                "\n, sqlDateColumn=" + sqlDateColumn +
                "\n, sqlTimeColumn=" + sqlTimeColumn +
                "\n}";
    }
}
