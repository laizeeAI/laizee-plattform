package de.fhaachen.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.fhaachen.handler.ApiClient;
import de.fhaachen.model.generated.*;
import de.fhaachen.model.login.LoginRequest;
import de.fhaachen.model.login.LoginResult;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-08-05T12:26:14.125952859+02:00[Europe/Berlin]")
@Component("io.codejournal.maven.swagger2java.api.DefaultApi")
public class DefaultApi {

    private static final Logger LOGGER = Logger.getLogger(DefaultApi.class);

    @Getter
    @Setter
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Analyze
     * Endpoint to analyze text provided in the request: - **text**: a text or a list of texts you want to analyze (required) - **token_based &#x60;WARNING: currently ignored&#x60;**: a flag to switch between char- and token-based   indices for extraction tasks.   Defaults to char-based (false). Affected tasks are:   - Named Entity Extraction (&#x60;TaskEnum.NER&#x60;)   - Keyword Extraction (&#x60;TaskEnum.KEYWORDS&#x60;) - **tasks**: A list of tasks to execute during document analysis. Defaults to empty list, which means every   task provided by the model will be executed. A spacy_model may ignore task, if it does not provide them. - **classes**: An optional list of classes which is used for prediction.   Defaults to an empty list. If a flair zero-shot classifier is used for classification, this is required. - **labels**: An optional list of labels used for prediction. Defaults to an empty list.   If a flair zero-shot classifier is used for named entity recognition, this is required. - **multi_label**: A flag to enable multi-label analysis. Defaults to false.
     * <p><b>200</b> - Returns a list of &#x60;AnalyzeResponse&#x60; (default, char-based) or &#x60;TokenBasedAnalyzeResponse&#x60;.
     * <p><b>422</b> - Validation Error
     *
     * @param body (required)
     * @return List&lt;AnalyzeResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<AnalyzeResponse> analyzeAnalyzePost(AnalyzeRequest body, LoginResult loginResult, String projectId, String serviceName) throws RestClientException {
        ResponseEntity<List<AnalyzeResponse>> result = analyzeAnalyzePostWithHttpInfo(body, loginResult, projectId, serviceName);
        List<AnalyzeResponse> resultBody = result.getBody();
        return resultBody;
    }

    /**
     * Analyze
     * Endpoint to analyze text provided in the request: - **text**: a text or a list of texts you want to analyze (required) - **token_based &#x60;WARNING: currently ignored&#x60;**: a flag to switch between char- and token-based   indices for extraction tasks.   Defaults to char-based (false). Affected tasks are:   - Named Entity Extraction (&#x60;TaskEnum.NER&#x60;)   - Keyword Extraction (&#x60;TaskEnum.KEYWORDS&#x60;) - **tasks**: A list of tasks to execute during document analysis. Defaults to empty list, which means every   task provided by the model will be executed. A spacy_model may ignore task, if it does not provide them. - **classes**: An optional list of classes which is used for prediction.   Defaults to an empty list. If a flair zero-shot classifier is used for classification, this is required. - **labels**: An optional list of labels used for prediction. Defaults to an empty list.   If a flair zero-shot classifier is used for named entity recognition, this is required. - **multi_label**: A flag to enable multi-label analysis. Defaults to false.
     * <p><b>200</b> - Returns a list of &#x60;AnalyzeResponse&#x60; (default, char-based) or &#x60;TokenBasedAnalyzeResponse&#x60;.
     * <p><b>422</b> - Validation Error
     *
     * @param body (required)
     * @return ResponseEntity&lt;List&lt;AnalyzeResponse&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<AnalyzeResponse>> analyzeAnalyzePostWithHttpInfo(AnalyzeRequest body,
                                                                                LoginResult loginResult,
                                                                                String projectId,
                                                                                String serviceName) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling analyzeAnalyzePost");
        }


        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        headerParams.setContentType(MediaType.APPLICATION_JSON);

        String path;

        if (loginResult != null) {
            headerParams.set("Bearer", loginResult.getAuth());
            headerParams.set("X-CSRFToken", loginResult.getCsrfToken());
            headerParams.add("Cookie", "sessionid=" + loginResult.getSessionId());
            headerParams.add("Cookie", "csrftoken=" + loginResult.getCsrfToken());

            String url = String.format("/v1/projects/%s/ml-endpoint/%s/analyze/", projectId, serviceName);
            path = UriComponentsBuilder.fromPath(url).build().toUriString();
        } else {
            path = UriComponentsBuilder.fromPath("/analyze/").build().toUriString();
        }

        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{};

        ParameterizedTypeReference<List<AnalyzeResponse>> returnType = new ParameterizedTypeReference<List<AnalyzeResponse>>() {
        };
        ResponseEntity<List<AnalyzeResponse>> listResponseEntity = apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
        return listResponseEntity;
    }

    /**
     * Details of the model
     * Endpoint to return all details of the currently loaded model
     * <p><b>200</b> - Endpoint to return all details of the currently loaded model.
     *
     * @return ModelDetailsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ModelDetailsResponse getDetailsModelDetailsGet() throws RestClientException {
        return getDetailsModelDetailsGetWithHttpInfo().getBody();
    }

    /**
     * Details of the model
     * Endpoint to return all details of the currently loaded model
     * <p><b>200</b> - Endpoint to return all details of the currently loaded model.
     *
     * @return ResponseEntity&lt;ModelDetailsResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ModelDetailsResponse> getDetailsModelDetailsGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/model/details").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{};

        ParameterizedTypeReference<ModelDetailsResponse> returnType = new ParameterizedTypeReference<ModelDetailsResponse>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Extract keywords
     * Endpoint to extract keywords from text provided in the request: - **text**: a text or a list of texts you want to extract keywords from (required) - **token_based &#x60;WARNING: currently ignored&#x60;**: a flag to switch between char- and token-based   indices for extraction tasks.   Defaults to char-based (false).
     * <p><b>200</b> - Endpoint to extract keywords from text.
     * <p><b>422</b> - Validation Error
     *
     * @param body (required)
     * @return List&lt;ExtractKeywordsResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ExtractKeywordsResponse> getKeywordsKeywordsPost(TextRequest body) throws RestClientException {
        return getKeywordsKeywordsPostWithHttpInfo(body).getBody();
    }

    /**
     * Extract keywords
     * Endpoint to extract keywords from text provided in the request: - **text**: a text or a list of texts you want to extract keywords from (required) - **token_based &#x60;WARNING: currently ignored&#x60;**: a flag to switch between char- and token-based   indices for extraction tasks.   Defaults to char-based (false).
     * <p><b>200</b> - Endpoint to extract keywords from text.
     * <p><b>422</b> - Validation Error
     *
     * @param body (required)
     * @return ResponseEntity&lt;List&lt;ExtractKeywordsResponse&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ExtractKeywordsResponse>> getKeywordsKeywordsPostWithHttpInfo(TextRequest body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling getKeywordsKeywordsPost");
        }
        String path = UriComponentsBuilder.fromPath("/keywords/").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{};

        ParameterizedTypeReference<List<ExtractKeywordsResponse>> returnType = new ParameterizedTypeReference<List<ExtractKeywordsResponse>>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Tasks of the model
     * Endpoint to return a list of all available tasks of the currently loaded model
     * <p><b>200</b> - Endpoint to return a list of all available tasks of the currently loaded model.
     *
     * @return List&lt;TaskDetails&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TaskDetails> getTasksModelTasksGet() throws RestClientException {
        return getTasksModelTasksGetWithHttpInfo().getBody();
    }

    /**
     * Tasks of the model
     * Endpoint to return a list of all available tasks of the currently loaded model
     * <p><b>200</b> - Endpoint to return a list of all available tasks of the currently loaded model.
     *
     * @return ResponseEntity&lt;List&lt;TaskDetails&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<TaskDetails>> getTasksModelTasksGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/model/tasks").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{};

        ParameterizedTypeReference<List<TaskDetails>> returnType = new ParameterizedTypeReference<List<TaskDetails>>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Root
     * Returns the Version of the Package
     * <p><b>200</b> - Successful Response
     *
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object rootGet() throws RestClientException {
        return rootGetWithHttpInfo().getBody();
    }

    /**
     * Root
     * Returns the Version of the Package
     * <p><b>200</b> - Successful Response
     *
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> rootGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{};

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Requests a login and stores received information.
     *
     * @param loginRequest given LoginRequest of an user
     * @return LoginResult with all nessesarry informations
     * @throws RestClientException
     */
    public LoginResult authLoginUser(LoginRequest loginRequest) throws RestClientException {
        Object body = loginRequest;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling authLoginUser");
        }
        String path = UriComponentsBuilder.fromPath("/v1/auth/login/").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[]{};

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
        };
        ResponseEntity<String> response = null;
        try {
            response = apiClient.invokeAPI(path,
                    HttpMethod.POST,
                    queryParams,
                    body,
                    headerParams,
                    formParams,
                    accept,
                    contentType,
                    authNames,
                    returnType);
        } catch (HttpClientErrorException httpClientErrorException) {
            LOGGER.info("Login Error - Client not found!");
            System.exit(0);
        }
        HttpHeaders headers = response.getHeaders();

        LoginResult loginResult = handleLoginResult(headers, response);
        return loginResult;
    }

    @SneakyThrows
    private LoginResult handleLoginResult(HttpHeaders headers, ResponseEntity<String> response) {
        List<String> cookies = headers.get(headers.SET_COOKIE);

        String csrfCookie = cookies.get(0);
        String csrfToken = csrfCookie.substring(csrfCookie.indexOf("=") + 1, csrfCookie.indexOf(";"));

        String sessionIdCookie = cookies.get(1);
        String sessionId = sessionIdCookie.substring(sessionIdCookie.indexOf("=") + 1, sessionIdCookie.indexOf(";"));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(response.getBody());
        String bearerToken = String.valueOf(node.get("key")).replace("\"", "");

        return new LoginResult(bearerToken, sessionId, csrfToken);
    }
}
