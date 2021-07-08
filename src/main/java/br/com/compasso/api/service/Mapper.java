package br.com.compasso.api.service;

public interface Mapper<A, B> {

    B map(A input);
}