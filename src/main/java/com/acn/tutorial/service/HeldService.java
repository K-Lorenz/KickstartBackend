package com.acn.tutorial.service;

import com.acn.tutorial.domain.Held;
import com.acn.tutorial.model.HeldDTO;
import com.acn.tutorial.repos.HeldRepository;
import com.acn.tutorial.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class HeldService {

    private final HeldRepository heldRepository;

    public HeldService(final HeldRepository heldRepository) {
        this.heldRepository = heldRepository;
    }

    public List<HeldDTO> findAll() {
        final List<Held> helds = heldRepository.findAll(Sort.by("id"));
        return helds.stream()
                .map(held -> mapToDTO(held, new HeldDTO()))
                .toList();
    }

    public HeldDTO get(final Long id) {
        return heldRepository.findById(id)
                .map(held -> mapToDTO(held, new HeldDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final HeldDTO heldDTO) {
        final Held held = new Held();
        mapToEntity(heldDTO, held);
        return heldRepository.save(held).getId();
    }

    public void update(final Long id, final HeldDTO heldDTO) {
        final Held held = heldRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(heldDTO, held);
        heldRepository.save(held);
    }

    public void delete(final Long id) {
        heldRepository.deleteById(id);
    }

    private HeldDTO mapToDTO(final Held held, final HeldDTO heldDTO) {
        heldDTO.setId(held.getId());
        heldDTO.setName(held.getName());
        heldDTO.setGeburtsjahr(held.getGeburtsjahr());
        return heldDTO;
    }

    private Held mapToEntity(final HeldDTO heldDTO, final Held held) {
        held.setName(heldDTO.getName());
        held.setGeburtsjahr(heldDTO.getGeburtsjahr());
        return held;
    }

}
