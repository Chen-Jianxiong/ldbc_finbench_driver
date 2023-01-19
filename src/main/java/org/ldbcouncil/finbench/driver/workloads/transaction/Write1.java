package org.ldbcouncil.finbench.driver.workloads.transaction;
/*
 * Transaction workload write query 1:
 * -- Add an Account Node owned by Person --
 * Add an account node. Add a Person node and an own edge from it to the account Node.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import org.ldbcouncil.finbench.driver.Operation;

public class Write1 extends Operation<LdbcNoResult> {
    public static final int TYPE = 1001;
    public static final String PERSON_ID = "personId";
    public static final String PERSON_NAME = "personName";
    public static final String ACCOUNT_ID = "accountId";
    public static final String CURRENT_TIME = "currentTime";
    public static final String ACCOUNT_BLOCKED = "accountBlocked";
    public static final String ACCOUNT_TYPE = "accountType";
    private final long personId;
    private final String personName;
    private final long accountId;
    private final Date currentTime;
    private final boolean accountBlocked;
    private final String accountType;

    public Write1(@JsonProperty(PERSON_ID) long personId,
                  @JsonProperty(PERSON_NAME) String personName,
                  @JsonProperty(ACCOUNT_ID) long accountId,
                  @JsonProperty(CURRENT_TIME) Date currentTime,
                  @JsonProperty(ACCOUNT_BLOCKED) boolean accountBlocked,
                  @JsonProperty(ACCOUNT_TYPE) String accountType) {
        this.personId = personId;
        this.personName = personName;
        this.accountId = accountId;
        this.currentTime = currentTime;
        this.accountBlocked = accountBlocked;
        this.accountType = accountType;
    }

    public long getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public long getAccountId() {
        return accountId;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public boolean getAccountBlocked() {
        return accountBlocked;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    public Map<String, Object> parameterMap() {
        return ImmutableMap.<String, Object>builder()
            .put(PERSON_ID, personId)
            .put(PERSON_NAME, personName)
            .put(ACCOUNT_ID, accountId)
            .put(CURRENT_TIME, currentTime)
            .put(ACCOUNT_BLOCKED, accountBlocked)
            .put(ACCOUNT_TYPE, accountType)
            .build();
    }

    @Override
    public LdbcNoResult deserializeResult(String serializedResults) {
        return LdbcNoResult.INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Write1 that = (Write1) o;
        return personId == that.personId
            && Objects.equals(personName, that.personName)
            && accountId == that.accountId
            && Objects.equals(currentTime, that.currentTime)
            && accountBlocked == that.accountBlocked
            && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName, accountId, currentTime, accountBlocked, accountType);
    }

    @Override
    public String toString() {
        return "Write1{"
            + "personId="
            + personId
            + ", personName="
            + personName
            + ", accountId="
            + accountId
            + ", currentTime="
            + currentTime
            + ", accountBlocked="
            + accountBlocked
            + ", accountType="
            + accountType
            + '}';
    }
}
