package de.laizee.model;

import de.laizee.model.generated.AnalyzeResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * This object class represents an extension of {@link GenericPair} and stores an {@link AnalyzeResponse} and {@link Result}.
 */
public class ResponseResultPair extends GenericPair<AnalyzeResponse, Result> {

    @Getter
    @Setter
    private boolean mapAble;

    /**
     * Constructor.
     *
     * @param response given response
     * @param result   given result
     */
    public ResponseResultPair(AnalyzeResponse response, Result result) {
        super(response, result);
        this.mapAble = true;
    }

    /**
     * Constructor.
     *
     * @param response given response
     * @param result   given result
     */
    public ResponseResultPair(AnalyzeResponse response, Result result, boolean mapAble) {
        super(response, result);
        this.mapAble = mapAble;
    }
}
