package com.george.thiroros.services;

import java.util.List;

import com.george.thiroros.domain.Node;

public interface ThirorosService {

	public Long addNode(Node node) throws Exception;

	public void removeNode(Long id) throws Exception;

	public List<Node> getNodes();

}
