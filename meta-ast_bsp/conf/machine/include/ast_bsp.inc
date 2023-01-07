UBOOT_ARCH ?= "arm"

#DISTRO_FEATURES ?= "ipv4 ipv6"

SOC_FAMILY = "aspeed-g5"
#include conf/machine/include/soc-family.inc
MACHINEOVERRIDES .= ":ast_bsp"
DEFAULTTUNE ?= "arm1176jzs"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-obmc"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-ast_bsp"
PREFERRED_PROVIDER_u-boot ?= "u-boot-ast_bsp"
PREFERRED_PROVIDER_u-boot-fw-utils ?= "u-boot-fw-utils-ast_bsp"

UBOOT_ENTRYPOINT ?= "0x80001000"
UBOOT_LOADADDRESS ?= "0x80001000"

MACHINE_FEATURES += "\
        obmc-phosphor-fan-mgmt \
        obmc-phosphor-chassis-mgmt \
        obmc-phosphor-flash-mgmt \
        obmc-host-ipmi \
        obmc-host-state-mgmt \
        obmc-chassis-state-mgmt \
        obmc-bmc-state-mgmt \
        "

VIRTUAL-RUNTIME_obmc-host-state-manager ?= "x86-power-control"
VIRTUAL-RUNTIME_obmc-chassis-state-manager ?= "x86-power-control"

PREFERRED_PROVIDER_virtual/obmc-host-ipmi-hw = "phosphor-ipmi-kcs"
PREFERRED_PROVIDER_virtual/obmc-chassis-mgmt = "packagegroup-hpe-apps"
PREFERRED_PROVIDER_virtual/obmc-fan-mgmt = "packagegroup-hpe-apps"
PREFERRED_PROVIDER_virtual/obmc-flash-mgmt = "packagegroup-hpe-apps"
PREFERRED_PROVIDER_virtual/obmc-system-mgmt = "packagegroup-hpe-apps"
PREFERRED_PROVIDER_virtual/obmc-host-ctl ?= ""
#PREFERRED_PROVIDER_virtual/phosphor-ipmi-fru-hostfw-config ?= "hostboot-inventory-config-native"

#IMAGE_CLASSES:append = " ast_bsp-rootfs-postcommands"
