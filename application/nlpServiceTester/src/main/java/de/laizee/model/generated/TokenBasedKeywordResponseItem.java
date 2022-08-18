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

package de.laizee.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;
/**
 * Pydantic model for a token-based index of an object.  start_token and end_token are positive integers where start_token &lt;&#x3D; end_token.
 */
@Schema(description = "Pydantic model for a token-based index of an object.  start_token and end_token are positive integers where start_token <= end_token.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-08-05T12:26:14.125952859+02:00[Europe/Berlin]")
public class TokenBasedKeywordResponseItem implements AnyOfAnalyzeResponseKeywordsItems, AnyOfExtractKeywordsResponseKeywordsItems {
  @JsonProperty("score")
  private BigDecimal score = null;

  @JsonProperty("keyword")
  private String keyword = null;

  @JsonProperty("start_token")
  private Integer startToken = null;

  @JsonProperty("end_token")
  private Integer endToken = null;

  public TokenBasedKeywordResponseItem score(BigDecimal score) {
    this.score = score;
    return this;
  }

   /**
   * Get score
   * @return score
  **/
  @Schema(description = "")
  public BigDecimal getScore() {
    return score;
  }

  public void setScore(BigDecimal score) {
    this.score = score;
  }

  public TokenBasedKeywordResponseItem keyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

   /**
   * Get keyword
   * @return keyword
  **/
  @Schema(required = true, description = "")
  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public TokenBasedKeywordResponseItem startToken(Integer startToken) {
    this.startToken = startToken;
    return this;
  }

   /**
   * Get startToken
   * @return startToken
  **/
  @Schema(required = true, description = "")
  public Integer getStartToken() {
    return startToken;
  }

  public void setStartToken(Integer startToken) {
    this.startToken = startToken;
  }

  public TokenBasedKeywordResponseItem endToken(Integer endToken) {
    this.endToken = endToken;
    return this;
  }

   /**
   * Get endToken
   * @return endToken
  **/
  @Schema(required = true, description = "")
  public Integer getEndToken() {
    return endToken;
  }

  public void setEndToken(Integer endToken) {
    this.endToken = endToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenBasedKeywordResponseItem tokenBasedKeywordResponseItem = (TokenBasedKeywordResponseItem) o;
    return Objects.equals(this.score, tokenBasedKeywordResponseItem.score) &&
        Objects.equals(this.keyword, tokenBasedKeywordResponseItem.keyword) &&
        Objects.equals(this.startToken, tokenBasedKeywordResponseItem.startToken) &&
        Objects.equals(this.endToken, tokenBasedKeywordResponseItem.endToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, keyword, startToken, endToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenBasedKeywordResponseItem {\n");
    
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
    sb.append("    startToken: ").append(toIndentedString(startToken)).append("\n");
    sb.append("    endToken: ").append(toIndentedString(endToken)).append("\n");
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