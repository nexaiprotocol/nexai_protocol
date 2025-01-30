package com.nexaiprotocol.protocol.module.mainnet.client;


import com.alibaba.fastjson2.JSONObject;

/**
 * Interface for sending HTTP requests to blockchain nodes.
 *
 * @since 1.0
 */


public interface BlockchainHttpClient {
    /**
     * Sends a JSON-RPC request to the specified RPC URL.
     *
     * @param rpcUrl The RPC URL of the blockchain node.
     * @param method The JSON-RPC method name.
     * @param params The parameters for the JSON-RPC method.
     * @return The response from the blockchain node as a JSONObject.
     * @throws RuntimeException If the request fails.
     */
    JSONObject sendRequest(String rpcUrl, String method, Object[] params);
}
