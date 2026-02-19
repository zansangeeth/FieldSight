package com.sangeeth.fieldsight

val investigations = listOf(
    investigation(1, "Gas odor reported near residential block", "2026-01-02", Priority.HIGH, Status.ASSIGNED, 40.7282, -73.7949, "Supervisor", emptyList(), emptyList()),
    investigation(2, "Routine pipeline inspection", "2026-01-03", Priority.LOW, Status.IN_PROGRESS, 40.7420, -73.9185, "Supervisor", emptyList(), emptyList()),
    investigation(3, "Commercial building gas alarm", "2026-01-03", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7061, -73.9969, "Supervisor", emptyList(), emptyList()),
    investigation(4, "Meter malfunction complaint", "2026-01-04", Priority.MEDIUM, Status.PAUSED, 40.6782, -73.9442, "Supervisor", emptyList(), emptyList()),
    investigation(5, "Gas smell in basement", "2026-01-04", Priority.HIGH, Status.IN_PROGRESS, 40.7614, -73.8293, "Supervisor", emptyList(), emptyList()),

    investigation(6, "Scheduled safety audit", "2026-01-05", Priority.LOW, Status.RESOLVED, 40.7898, -73.1349, "Supervisor", emptyList(), emptyList()),
    investigation(7, "Public report of hissing sound", "2026-01-05", Priority.MEDIUM, Status.ASSIGNED, 40.7419, -73.7154, "Supervisor", emptyList(), emptyList()),
    investigation(8, "Emergency call from restaurant", "2026-01-06", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7336, -73.5868, "Supervisor", emptyList(), emptyList()),
    investigation(9, "Old pipeline pressure drop", "2026-01-06", Priority.MEDIUM, Status.IN_PROGRESS, 40.7851, -73.4287, "Supervisor", emptyList(), emptyList()),
    investigation(10, "Construction-related gas concern", "2026-01-07", Priority.MEDIUM, Status.NO_GAS_LEAK_FOUND, 40.7259, -73.2454, "Supervisor", emptyList(), emptyList()),

    investigation(11, "Tenant reports recurring odor", "2026-01-07", Priority.HIGH, Status.IN_PROGRESS, 40.7543, -73.6187, "Supervisor", emptyList(), emptyList()),
    investigation(12, "Preventive infrastructure check", "2026-01-08", Priority.LOW, Status.RESOLVED, 40.8096, -73.0205, "Supervisor", emptyList(), emptyList()),
    investigation(13, "Utility sensor alert", "2026-01-08", Priority.HIGH, Status.ASSIGNED, 40.6951, -73.7312, "Supervisor", emptyList(), emptyList()),
    investigation(14, "School building inspection", "2026-01-09", Priority.MEDIUM, Status.PAUSED, 40.8122, -73.4678, "Supervisor", emptyList(), emptyList()),
    investigation(15, "Gas odor near subway entrance", "2026-01-09", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7129, -73.9067, "Supervisor", emptyList(), emptyList()),

    investigation(16, "Annual compliance inspection", "2026-01-10", Priority.LOW, Status.RESOLVED, 40.7810, -73.5621, "Supervisor", emptyList(), emptyList()),
    investigation(17, "Pressure irregularity detected", "2026-01-10", Priority.MEDIUM, Status.IN_PROGRESS, 40.8467, -73.3875, "Supervisor", emptyList(), emptyList()),
    investigation(18, "Warehouse gas alarm", "2026-01-11", Priority.HIGH, Status.NEED_SUPPORT, 40.7364, -73.1862, "Supervisor", emptyList(), emptyList()),
    investigation(19, "Resident complaint after storm", "2026-01-11", Priority.MEDIUM, Status.ASSIGNED, 40.6689, -73.8523, "Supervisor", emptyList(), emptyList()),
    investigation(20, "Gas line vibration report", "2026-01-12", Priority.MEDIUM, Status.NO_GAS_LEAK_FOUND, 40.8194, -73.6704, "Supervisor", emptyList(), emptyList()),

    investigation(21, "Emergency services referral", "2026-01-12", Priority.HIGH, Status.IN_PROGRESS, 40.7074, -74.0113, "Supervisor", emptyList(), emptyList()),
    investigation(22, "Retail store alarm triggered", "2026-01-13", Priority.MEDIUM, Status.GAS_LEAK_FOUND, 40.7589, -73.9851, "Supervisor", emptyList(), emptyList()),
    investigation(23, "Apartment building inspection", "2026-01-13", Priority.MEDIUM, Status.PAUSED, 40.7369, -73.9916, "Supervisor", emptyList(), emptyList()),
    investigation(24, "Preventive valve check", "2026-01-14", Priority.LOW, Status.RESOLVED, 40.8005, -73.9590, "Supervisor", emptyList(), emptyList()),
    investigation(25, "Gas odor reported by passerby", "2026-01-14", Priority.HIGH, Status.ASSIGNED, 40.6928, -73.9903, "Supervisor", emptyList(), emptyList()),

    investigation(26, "Pipeline maintenance follow-up", "2026-01-15", Priority.LOW, Status.IN_PROGRESS, 40.8291, -73.5156, "Supervisor", emptyList(), emptyList()),
    investigation(27, "Community center gas alarm", "2026-01-15", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7512, -73.7769, "Supervisor", emptyList(), emptyList()),
    investigation(28, "Routine inspection – residential", "2026-01-16", Priority.LOW, Status.RESOLVED, 40.8884, -73.3817, "Supervisor", emptyList(), emptyList()),
    investigation(29, "Odor complaint near marina", "2026-01-16", Priority.MEDIUM, Status.IN_PROGRESS, 40.9046, -73.1281, "Supervisor", emptyList(), emptyList()),
    investigation(30, "Pressure sensor anomaly", "2026-01-17", Priority.HIGH, Status.NEED_SUPPORT, 40.7836, -73.9661, "Supervisor", emptyList(), emptyList()),

    investigation(31, "Gas leak suspicion in garage", "2026-01-17", Priority.HIGH, Status.ASSIGNED, 40.7321, -73.8645, "Supervisor", emptyList(), emptyList()),
    investigation(32, "Follow-up inspection after repair", "2026-01-18", Priority.LOW, Status.RESOLVED, 40.7098, -73.8146, "Supervisor", emptyList(), emptyList()),
    investigation(33, "School safety inspection", "2026-01-18", Priority.MEDIUM, Status.IN_PROGRESS, 40.8459, -73.7028, "Supervisor", emptyList(), emptyList()),
    investigation(34, "Subsurface gas reading elevated", "2026-01-19", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7648, -73.7391, "Supervisor", emptyList(), emptyList()),
    investigation(35, "Utility crew referral", "2026-01-19", Priority.MEDIUM, Status.PAUSED, 40.7873, -73.6504, "Supervisor", emptyList(), emptyList()),

    investigation(36, "Gas odor reported by business", "2026-01-20", Priority.HIGH, Status.IN_PROGRESS, 40.7216, -73.8774, "Supervisor", emptyList(), emptyList()),
    investigation(37, "Pipeline corrosion check", "2026-01-20", Priority.MEDIUM, Status.NO_GAS_LEAK_FOUND, 40.8702, -73.4479, "Supervisor", emptyList(), emptyList()),
    investigation(38, "Emergency alarm – residential", "2026-01-21", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7455, -73.9032, "Supervisor", emptyList(), emptyList()),
    investigation(39, "Valve integrity inspection", "2026-01-21", Priority.LOW, Status.RESOLVED, 40.8127, -73.5862, "Supervisor", emptyList(), emptyList()),
    investigation(40, "Construction site gas concern", "2026-01-22", Priority.MEDIUM, Status.ASSIGNED, 40.7792, -73.8218, "Supervisor", emptyList(), emptyList()),

    investigation(41, "Gas odor near shopping plaza", "2026-01-22", Priority.HIGH, Status.IN_PROGRESS, 40.7654, -73.5321, "Supervisor", emptyList(), emptyList()),
    investigation(42, "Routine compliance audit", "2026-01-23", Priority.LOW, Status.RESOLVED, 40.8899, -73.2459, "Supervisor", emptyList(), emptyList()),
    investigation(43, "Pressure drop alert", "2026-01-23", Priority.MEDIUM, Status.IN_PROGRESS, 40.7008, -73.9199, "Supervisor", emptyList(), emptyList()),
    investigation(44, "Apartment gas alarm", "2026-01-24", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7287, -73.9846, "Supervisor", emptyList(), emptyList()),
    investigation(45, "Follow-up after storm damage", "2026-01-24", Priority.MEDIUM, Status.NEED_SUPPORT, 40.8234, -73.3047, "Supervisor", emptyList(), emptyList()),

    investigation(46, "Preventive inspection – industrial", "2026-01-25", Priority.LOW, Status.RESOLVED, 40.9181, -73.0864, "Supervisor", emptyList(), emptyList()),
    investigation(47, "Resident complaint – recurring odor", "2026-01-25", Priority.HIGH, Status.ASSIGNED, 40.7449, -73.7033, "Supervisor", emptyList(), emptyList()),
    investigation(48, "Gas meter anomaly", "2026-01-26", Priority.MEDIUM, Status.IN_PROGRESS, 40.8665, -73.5968, "Supervisor", emptyList(), emptyList()),
    investigation(49, "Emergency services escalation", "2026-01-26", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7112, -73.9576, "Supervisor", emptyList(), emptyList()),
    investigation(50, "Final clearance inspection", "2026-01-27", Priority.LOW, Status.RESOLVED, 40.8041, -73.4832, "Supervisor", emptyList(), emptyList())
)