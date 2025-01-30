package com.nexaiprotocol.protocol.module.mainnet;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

/**
 * Interface for interacting with a blockchain.
 *
 * @since 1.0
 */

public interface BlockchainMainnet {
    /**
     * Sends a JSON-RPC request to the blockchain.
     *
     * @param method The JSON-RPC method name.
     * @param params The parameters for the JSON-RPC method.
     * @return The response from the blockchain node as a JSONObject.
     */
    JSONObject sendRequest(String method, Object[] params);

    /**
     * Gets the balance of an account.
     *
     * @param address The account address.
     * @return The account balance.
     */
    String getBalance(String address);

    /**
     * Gets the current block height.
     *
     * @return The current block height.
     */
    long getBlockHeight();

    /**
     * Gets the recent block hash.
     *
     * @return The current block hash.
     */
    String getRecentBlockhash();

    /**
     * Gets the transaction details by transaction hash.
     *
     * @param txHash The transaction hash.
     * @return The transaction details as a JSONObject.
     * @throws RuntimeException If the transaction details cannot be retrieved due to an error.
     */
    JSONObject getTransaction(String txHash);

    /**
     * Sends a signed transaction to the specified blockchain.
     *
     * @param signedTx The signed transaction data.
     * @return The transaction hash.
     * @throws RuntimeException If the transaction fails to be sent due to an error.
     */
    String sendTransaction(String signedTx);

    /**
     * Gets the gas price (or equivalent) for the specified blockchain.
     *
     * @return The gas price as a string.
     * @throws RuntimeException If the gas price cannot be retrieved due to an error.
     */
    String getGasPrice();

    /**
     * Gets the list of transactions for a specific address.
     *
     * @param address The account address.
     * @param limit   The maximum number of transactions to return.
     * @return A list of transactions as a JSONArray.
     * @throws RuntimeException If the transactions cannot be retrieved due to an error.
     */
    JSONArray getTransactionsByAddress(String address, int limit);

    /**
     * Gets the details of a smart contract.
     *
     * @param contractAddress The contract address.
     * @return The contract details as a JSONObject (e.g., ABI, bytecode).
     * @throws RuntimeException If the contract details cannot be retrieved due to an error.
     */
    JSONObject getContractDetails(String contractAddress);

    /**
     * Calls a read-only function on a smart contract.
     *
     * @param contractAddress The contract address.
     * @param functionName    The name of the function to call.
     * @param params          The parameters for the function.
     * @return The result of the function call as a string.
     * @throws RuntimeException If the function call fails due to an error.
     */
    String callContractFunction(String contractAddress, String functionName, Object[] params);

    /**
     * Estimates the gas limit for a transaction.
     *
     * @param from  The sender address.
     * @param to    The recipient address.
     * @param value The amount to send.
     * @param data  The transaction data.
     * @return The estimated gas limit as a long value.
     * @throws RuntimeException If the gas limit cannot be estimated due to an error.
     */
    long estimateGas(String from, String to, String value, String data);

    /**
     * Gets the list of tokens owned by an address (e.g., ERC-20 tokens on Ethereum).
     *
     * @param address The account address.
     * @return A list of tokens as a JSONArray.
     * @throws RuntimeException If the tokens cannot be retrieved due to an error.
     */
    JSONArray getTokensByAddress(String address);

    /**
     * Gets the details of a specific token (e.g., name, symbol, decimals).
     *
     * @param tokenAddress The token contract address.
     * @return The token details as a JSONObject.
     * @throws RuntimeException If the token details cannot be retrieved due to an error.
     */
    JSONObject getTokenDetails(String tokenAddress);

    /**
     * Gets the list of validators (for PoS blockchains like Ethereum 2.0, Solana, etc.).
     *
     * @return A list of validators as a JSONArray.
     * @throws RuntimeException If the validators cannot be retrieved due to an error.
     */
    JSONArray getValidators();

    /**
     * Gets the list of pending transactions in the mempool.
     *
     * @return A list of pending transactions as a JSONArray.
     * @throws RuntimeException If the pending transactions cannot be retrieved due to an error.
     */
    JSONArray getPendingTransactions();
}
