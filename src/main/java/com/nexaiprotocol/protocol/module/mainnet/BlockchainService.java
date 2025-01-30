package com.nexaiprotocol.protocol.module.mainnet;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

/**
 * Interface for interacting with multiple blockchains.
 * This interface defines common operations that can be performed on any supported blockchain.
 *
 * @since 1.0
 */
public interface BlockchainService {

    /**
     * Gets the balance of an account on the specified blockchain.
     *
     * @param chain   The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param address The account address.
     * @return The account balance as a string (e.g., in wei, lamports, or other blockchain-specific units).
     * @throws RuntimeException If the balance cannot be retrieved due to an error.
     */
    default String getBalance(String chain, String address) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        return blockchain.getBalance(address);
    }

    /**
     * Gets the current block height of the specified blockchain.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @return The current block height as a long value.
     * @throws RuntimeException If the block height cannot be retrieved due to an error.
     */
    default long getBlockHeight(String chain) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        return blockchain.getBlockHeight();
    }

    /**
     * Gets the recent block hash.
     *
     * @return The current block hash.
     */
    default String getRecentBlockhash(String chain) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        String blockhash = blockchain.getRecentBlockhash();
        return blockhash;
    }

    /**
     * Gets the transaction details by transaction hash.
     *
     * @param chain  The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param txHash The transaction hash.
     * @return The transaction details as a JSONObject.
     * @throws RuntimeException If the transaction details cannot be retrieved due to an error.
     */
    default JSONObject getTransaction(String chain, String txHash) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        return blockchain.getTransaction(txHash);
    }

    /**
     * Sends a signed transaction to the specified blockchain.
     *
     * @param chain     The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param storeData The signed transaction data.
     * @return The transaction hash.
     * @throws RuntimeException If the transaction fails to be sent due to an error.
     */
    default String sendTransaction(String chain, String storeData) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        String transaction = blockchain.sendTransaction(storeData);
        return transaction;
    }

    /**
     * Gets the gas price (or equivalent) for the specified blockchain.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @return The gas price as a string.
     * @throws RuntimeException If the gas price cannot be retrieved due to an error.
     */
    default String getGasPrice(String chain) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        String gasPrice = blockchain.getGasPrice();
        return gasPrice;
    }

    /**
     * Gets the list of transactions for a specific address.
     *
     * @param chain   The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param address The account address.
     * @param limit   The maximum number of transactions to return.
     * @return A list of transactions as a JSONArray.
     * @throws RuntimeException If the transactions cannot be retrieved due to an error.
     */
    default JSONArray getTransactionsByAddress(String chain, String address, int limit) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        JSONArray transactions = blockchain.getTransactionsByAddress(address, limit);
        return transactions;
    }

    /**
     * Gets the details of a smart contract.
     *
     * @param chain           The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param contractAddress The contract address.
     * @return The contract details as a JSONObject (e.g., ABI, bytecode).
     * @throws RuntimeException If the contract details cannot be retrieved due to an error.
     */
    default JSONObject getContractDetails(String chain, String contractAddress) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        JSONObject contractDetails = blockchain.getContractDetails(contractAddress);
        return contractDetails;
    }

    /**
     * Calls a read-only function on a smart contract.
     *
     * @param chain           The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param contractAddress The contract address.
     * @param functionName    The name of the function to call.
     * @param params          The parameters for the function.
     * @return The result of the function call as a string.
     * @throws RuntimeException If the function call fails due to an error.
     */
    default String callContractFunction(String chain, String contractAddress, String functionName, Object[] params) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        String contractFunction = blockchain.callContractFunction(contractAddress, functionName, params);
        return contractFunction;
    }

    /**
     * Estimates the gas limit for a transaction.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param from  The sender address.
     * @param to    The recipient address.
     * @param value The amount to send.
     * @param data  The transaction data.
     * @return The estimated gas limit as a long value.
     * @throws RuntimeException If the gas limit cannot be estimated due to an error.
     */
    default long estimateGas(String chain, String from, String to, String value, String data) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        long gas = blockchain.estimateGas(from, to, value, data);
        return gas;
    }

    /**
     * Gets the list of tokens owned by an address (e.g., ERC-20 tokens on Ethereum).
     *
     * @param chain   The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param address The account address.
     * @return A list of tokens as a JSONArray.
     * @throws RuntimeException If the tokens cannot be retrieved due to an error.
     */
    default JSONArray getTokensByAddress(String chain, String address) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        JSONArray tokens = blockchain.getTokensByAddress(address);
        return tokens;
    }

    /**
     * Gets the details of a specific token (e.g., name, symbol, decimals).
     *
     * @param chain        The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @param tokenAddress The token contract address.
     * @return The token details as a JSONObject.
     * @throws RuntimeException If the token details cannot be retrieved due to an error.
     */
    default JSONObject getTokenDetails(String chain, String tokenAddress) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        JSONObject details = blockchain.getTokenDetails(tokenAddress);
        return details;
    }

    /**
     * Gets the list of validators (for PoS blockchains like Ethereum 2.0, Solana, etc.).
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @return A list of validators as a JSONArray.
     * @throws RuntimeException If the validators cannot be retrieved due to an error.
     */
    default JSONArray getValidators(String chain) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        JSONArray validators = blockchain.getValidators();
        return validators;
    }

    /**
     * Gets the list of pending transactions in the mempool.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @return A list of pending transactions as a JSONArray.
     * @throws RuntimeException If the pending transactions cannot be retrieved due to an error.
     */
    default JSONArray getPendingTransactions(String chain) {
        BlockchainMainnet blockchain = getBlockchainInstance(chain);
        JSONArray pendingTransactions = blockchain.getPendingTransactions();
        return pendingTransactions;
    }

    /**
     * Gets an instance of the blockchain client for the specified chain.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base", "polygon").
     * @return An instance of BlockchainMainnet.
     * @throws IllegalArgumentException If the chain is not supported.
     */
    BlockchainMainnet getBlockchainInstance(String chain);
}
