package org.ldbcouncil.finbench.driver.workloads.transaction;
/*
 * Transaction workload simple read query 8:
 * -- Many-to-one blocked account monitoring --
 * Given an Account, find the ratio of transfer-ins from blocked Accounts in all itstransfer-ins in a specific
time range between start_time and end_time. Return the ratio.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.ldbcouncil.finbench.driver.Operation;

public class SimpleRead8 extends Operation<List<SimpleRead8Result>> {
    public static final int TYPE = 108;
    public static final String ID = "id";
    public static final String THRESHOLD = "threshold";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final long id;
    private final long threshold;
    private final Date startTime;
    private final Date endTime;

    public SimpleRead8(@JsonProperty(ID) long id,
                       @JsonProperty(THRESHOLD) long threshold,
                       @JsonProperty(START_TIME) Date startTime,
                       @JsonProperty(END_TIME) Date endTime) {
        this.id = id;
        this.threshold = threshold;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public long getThreshold() {
        return threshold;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    public Map<String, Object> parameterMap() {
        return ImmutableMap.<String, Object>builder()
            .put(ID, id)
            .put(THRESHOLD, threshold)
            .put(START_TIME, startTime)
            .put(END_TIME, endTime)
            .build();
    }

    @Override
    public List<SimpleRead8Result> deserializeResult(String serializedOperationResult) throws IOException {
        return Arrays.asList(OBJECT_MAPPER.readValue(serializedOperationResult, SimpleRead8Result[].class));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleRead8 that = (SimpleRead8) o;
        return id == that.id
            && threshold == that.threshold
            && Objects.equals(startTime, that.startTime)
            && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, threshold, startTime, endTime);
    }

    @Override
    public String toString() {
        return "SimpleRead8{"
            + "id="
            + id
            + ", threshold="
            + threshold
            + ", startTime="
            + startTime
            + ", endTime="
            + endTime
            + '}';
    }
}
