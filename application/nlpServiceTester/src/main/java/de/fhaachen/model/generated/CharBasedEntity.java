/*
 * las-web
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.1.0rc7
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package de.fhaachen.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Pydantic model for a char-based index of an object.  start_char and end_char are positive integers where start_char &lt; end_char.
 */
@Schema(description = "Pydantic model for a char-based index of an object.  start_char and end_char are positive integers where start_char < end_char.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-08-05T12:26:14.125952859+02:00[Europe/Berlin]")
public class CharBasedEntity implements AnyOfAnalyzeResponseEntitiesItems, AnyOfRelationResponseItemEntityFirst, AnyOfRelationResponseItemEntitySecond {
    @JsonProperty("score")
    private BigDecimal score = null;

    @JsonProperty("text")
    private String text = null;

    @JsonProperty("label")
    private String label = null;

    @JsonProperty("start_char")
    private Integer startChar = null;

    @JsonProperty("end_char")
    private Integer endChar = null;

    public CharBasedEntity() {

    }

    public CharBasedEntity score(BigDecimal score) {
        this.score = score;
        return this;
    }

    /**
     * Get score
     *
     * @return score
     **/
    @Schema(description = "")
    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public CharBasedEntity text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     **/
    @Schema(required = true, description = "")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CharBasedEntity label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Get label
     *
     * @return label
     **/
    @Schema(required = true, description = "")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CharBasedEntity startChar(Integer startChar) {
        this.startChar = startChar;
        return this;
    }

    /**
     * Get startChar
     *
     * @return startChar
     **/
    @Schema(required = true, description = "")
    public Integer getStartChar() {
        return startChar;
    }

    public void setStartChar(Integer startChar) {
        this.startChar = startChar;
    }

    public CharBasedEntity endChar(Integer endChar) {
        this.endChar = endChar;
        return this;
    }

    /**
     * Get endChar
     *
     * @return endChar
     **/
    @Schema(required = true, description = "")
    public Integer getEndChar() {
        return endChar;
    }

    public void setEndChar(Integer endChar) {
        this.endChar = endChar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharBasedEntity charBasedEntity = (CharBasedEntity) o;
        return Objects.equals(this.score, charBasedEntity.score) &&
                Objects.equals(this.text, charBasedEntity.text) &&
                Objects.equals(this.label, charBasedEntity.label) &&
                Objects.equals(this.startChar, charBasedEntity.startChar) &&
                Objects.equals(this.endChar, charBasedEntity.endChar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, text, label, startChar, endChar);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharBasedEntity {\n");

        sb.append("    score: ").append(toIndentedString(score)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    startChar: ").append(toIndentedString(startChar)).append("\n");
        sb.append("    endChar: ").append(toIndentedString(endChar)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
