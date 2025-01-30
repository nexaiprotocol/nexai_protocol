package com.nexaiprotocol.protocol.module.mainnet.client;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Utility class for sending HTTP requests to blockchain nodes.
 *
 * @since 1.0
 */


public class DefaultBlockchainHttpClient implements BlockchainHttpClient {

    /**
     * Sends a JSON-RPC request to the specified RPC URL.
     *
     * @param rpcUrl The RPC URL of the blockchain node.
     * @param method The JSON-RPC method name.
     * @param params The parameters for the JSON-RPC method.
     * @return The response from the blockchain node as a JSONObject.
     * @throws RuntimeException If the request fails.
     */
    @Override
    public JSONObject sendRequest(String rpcUrl, String method, Object[] params) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(rpcUrl);
            httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
            //"application/json; charset=utf-8"

            // Build the JSON-RPC request body
            JSONObject requestBody = new JSONObject();
            requestBody.put("jsonrpc", "2.0");
            requestBody.put("id", 1);
            requestBody.put("method", method);
            requestBody.put("params", params);

            httpPost.setEntity(new StringEntity(requestBody.toJSONString()));

            // Execute the request
            HttpResponse response = httpClient.execute(httpPost);
            String responseBody = EntityUtils.toString(response.getEntity());

            // Parse the response using Fastjson2
            JSONObject jsonResponse = JSON.parseObject(responseBody);

            // Check for errors in the response
            if (jsonResponse.containsKey("error")) {
                throw new RuntimeException("Client request returned an error: " + jsonResponse.getJSONObject("error"));
            }

            return jsonResponse;
        } catch (IOException e) {
            throw new RuntimeException("Failed to send request to blockchain node", e);
        }
    }
}
