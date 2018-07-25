package com.george.thiroros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.george.thiroros.domain.Node;
import com.george.thiroros.domain.Thiroros;
import com.george.thiroros.services.ThirorosService;

@Service("Thiroros")
public class ThirorosServiceImpl implements ThirorosService {

	@Autowired
	private Thiroros thiroros;

	public Long addNode(Node node) throws Exception {
		return thiroros.addNode(node);
	}

	public List<Node> getNodes() {
		return thiroros.getNodes();
	}

	public void removeNode(Long id) throws Exception {
		thiroros.removeNode(id);
	}

}
