SUMMARY = "NVMe Drive Manager"
DESCRIPTION = "Daemon to monitor and report the status of NVMe drives"
HOMEPAGE = "https://github.com/openbmc/phosphor-nvme"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit meson pkgconfig
inherit systemd

DEPENDS += "sdbusplus"
DEPENDS += "phosphor-dbus-interfaces"
DEPENDS += "sdeventplus"
DEPENDS += "phosphor-logging"
DEPENDS += "nlohmann-json"

SRC_URI = "git://github.com/openbmc/phosphor-nvme.git;protocol=https;branch=master"
SRCREV = "5022a4ee5cd4d3eaeabc4e991507e71b35b26a16"
S = "${WORKDIR}/git"

SYSTEMD_SERVICE:${PN} = "xyz.openbmc_project.nvme.manager.service"
