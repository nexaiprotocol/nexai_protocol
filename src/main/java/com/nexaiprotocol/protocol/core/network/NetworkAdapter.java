package com.nexaiprotocol.protocol.core.network;


import com.nexaiprotocol.common.exception.AdapterException;

import java.util.Map;

/**
 * Base interface for network adapters providing common communication capabilities.
 * All specific business network adapters should implement this interface.
 *
 * @since 1.0
 */


public interface NetworkAdapter {
    /**
     * Initializes the network connection with specified configuration
     *
     * @param config Configuration parameters as key-value pairs
     * @throws AdapterException If initialization fails
     */
    void initialize(Map<String, Object> config) throws AdapterException;

    /**
     * Sends a request through the network adapter
     *
     * @param payload Data to be sent
     * @return Response from the network
     * @throws AdapterException If request fails
     */
    String sendRequest(String payload) throws AdapterException;

    /**
     * Processes received response data
     *
     * @param response Raw response data from network
     * @return Processed result
     */
    Object processResponse(String response);

    /**
     * Terminates the network connection
     */
    void shutdown();

    /**
     * Checks if the adapter is currently connected
     *
     * @return Connection status
     */
    boolean isConnected();

    /**
     * Handles adapter-specific errors
     *
     * @param errorCode Error identification code
     * @param message   Error description
     */
    void handleError(int errorCode, String message);
}