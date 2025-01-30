package com.nexaiprotocol.protocol.core.network;


import java.io.InputStream;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * <p>
 * Main network adapter interface providing access to sub-adapters
 * for different domains: Blockchain, Storage, and Large Language Model (LLM)
 */
public interface BaseNetworkAdapter {

    /**
     * Get blockchain network adapter instance
     */
    BlockchainAdapter getBlockchainAdapter();

    /**
     * Get cloud storage adapter instance
     */
    StorageAdapter getStorageAdapter();

    /**
     * Get Large Language Model adapter instance
     */
    LLMAdapter getLLMAdapter();


    //*************************************
    // Sub-interfaces

    /**
     * Blockchain network operations interface
     */
    interface BlockchainAdapter {
        /**
         * Submit transaction to blockchain network
         *
         * @param transactionData Raw transaction data in bytes
         * @param txType          Transaction type (e.g., "ETHEREUM", "FABRIC")
         * @param callback        Async operation callback
         */
        void submitTransaction(byte[] transactionData, String txType, CompletionCallback<String> callback);

        /**
         * Query data from blockchain network
         *
         * @param queryParams Query parameters in JSON format
         * @param timeoutMs   Timeout in milliseconds
         * @return Query result in JSON format
         */
        String queryBlockchainData(String queryParams, long timeoutMs);

        /**
         * Call smart contract method
         *
         * @param contractAddress Contract address/hash
         * @param methodName      Contract method name
         * @param params          Method parameters in JSON format
         * @param callback        Async operation callback
         */
        void callSmartContract(String contractAddress, String methodName, String params, CompletionCallback<String> callback);
    }

    /**
     * Cloud storage operations interface
     */
    interface StorageAdapter {
        /**
         * Upload file to decentralized storage
         *
         * @param fileData    File content in bytes
         * @param storageType Storage type (e.g., "IPFS", "ARWEAVE")
         * @param callback    Async operation callback
         */
        void uploadFile(byte[] fileData, String storageType, CompletionCallback<String> callback);

        /**
         * Download file from storage network
         *
         * @param filePath    File path/identifier
         * @param storageType Storage type (e.g., "IPFS", "ARWEAVE")
         * @return File content stream
         */
        InputStream downloadFile(String filePath, String storageType);

        /**
         * Delete file from storage network
         *
         * @param filePath    File path/identifier
         * @param storageType Storage type (e.g., "IPFS", "ARWEAVE")
         * @param callback    Async operation callback
         */
        void deleteFile(String filePath, String storageType, CompletionCallback<Boolean> callback);

        /**
         * Get file metadata
         *
         * @param filePath    File path/identifier
         * @param storageType Storage type (e.g., "IPFS", "ARWEAVE")
         * @return Metadata in JSON format
         */
        String getFileMetadata(String filePath, String storageType);
    }

    /**
     * Large Language Model operations interface
     */
    interface LLMAdapter {
        /**
         * Perform synchronous model inference
         *
         * @param inputData    Input data in JSON format
         * @param modelVersion Model version identifier
         * @param timeoutMs    Timeout in milliseconds
         * @return Inference result in JSON format
         */
        String inference(String inputData, String modelVersion, long timeoutMs);

        /**
         * Perform asynchronous model inference
         *
         * @param inputData    Input data in JSON format
         * @param modelVersion Model version identifier
         * @param callback     Async operation callback
         */
        void asyncInference(String inputData, String modelVersion, CompletionCallback<String> callback);

        /**
         * Get model information
         *
         * @param modelVersion Model version identifier
         * @return Model metadata in JSON format
         */
        String getModelInfo(String modelVersion);
    }

    /**
     * Generic async operation callback interface
     *
     * @param <T> Type of operation result
     */
    interface CompletionCallback<T> {
        void onSuccess(T result);

        void onFailure(Throwable error);
    }
}
