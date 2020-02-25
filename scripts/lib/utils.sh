#!/usr/bin/env bash

# -----------------------------------------------------------------------------------------------------
# Shell Utils
# @author Zhang Peng
# -----------------------------------------------------------------------------------------------------

# ------------------------------------------------------------------------------ env params

#  颜色状态
# Regular Color
export ENV_COLOR_BLACK="\033[0;30m"
export ENV_COLOR_RED="\033[0;31m"
export ENV_COLOR_GREEN="\033[0;32m"
export ENV_COLOR_YELLOW="\033[0;33m"
export ENV_COLOR_BLUE="\033[0;34m"
export ENV_COLOR_MAGENTA="\033[0;35m"
export ENV_COLOR_CYAN="\033[0;36m"
export ENV_COLOR_WHITE="\033[0;37m"
# Bold Color
export ENV_COLOR_B_BLACK="\033[1;30m"
export ENV_COLOR_B_RED="\033[1;31m"
export ENV_COLOR_B_GREEN="\033[1;32m"
export ENV_COLOR_B_YELLOW="\033[1;33m"
export ENV_COLOR_B_BLUE="\033[1;34m"
export ENV_COLOR_B_MAGENTA="\033[1;35m"
export ENV_COLOR_B_CYAN="\033[1;36m"
export ENV_COLOR_B_WHITE="\033[1;37m"
# Underline Color
export ENV_COLOR_U_BLACK="\033[4;30m"
export ENV_COLOR_U_RED="\033[4;31m"
export ENV_COLOR_U_GREEN="\033[4;32m"
export ENV_COLOR_U_YELLOW="\033[4;33m"
export ENV_COLOR_U_BLUE="\033[4;34m"
export ENV_COLOR_U_MAGENTA="\033[4;35m"
export ENV_COLOR_U_CYAN="\033[4;36m"
export ENV_COLOR_U_WHITE="\033[4;37m"
# Background Color
export ENV_COLOR_BG_BLACK="\033[40m"
export ENV_COLOR_BG_RED="\033[41m"
export ENV_COLOR_BG_GREEN="\033[42m"
export ENV_COLOR_BG_YELLOW="\033[43m"
export ENV_COLOR_BG_BLUE="\033[44m"
export ENV_COLOR_BG_MAGENTA="\033[45m"
export ENV_COLOR_BG_CYAN="\033[46m"
export ENV_COLOR_BG_WHITE="\033[47m"
# Reset Color
export ENV_COLOR_RESET="$(tput sgr0)"

# 常用状态值
export ENV_YES=0
export ENV_NO=1
export ENV_SUCCEED=0
export FAILED=1


# ------------------------------------------------------------------------------ functions

# 显示打印日志的时间
DATE=$(date "+%Y-%m-%d %H:%M:%S")
# 那个用户在操作
USER=$(whoami)
# 日志路径
LOG_DIR=${FIDE_LOG_DIR:-/var/log/fide}
LOG_PATH=${LOG_DIR}/shell.log

createLogFileIfNotExists() {
    if [[ ! -x "${LOG_PATH}" ]]; then
    mkdir -p "${LOG_DIR}"
    touch "${LOG_PATH}"
    fi
}

logInfo() {
    echo -e "${ENV_COLOR_B_GREEN}[INFO] $@${ENV_COLOR_RESET}"
    createLogFileIfNotExists
    echo "[${DATE}] [${USER}] [INFO] [$0] [$@] execute succeed." >> "${LOG_PATH}"
}

logWarn() {
    echo -e "${ENV_COLOR_B_YELLOW}[WARN] $@${ENV_COLOR_RESET}"
    createLogFileIfNotExists
    echo "[${DATE}] [${USER}] [WARN] [$0] [$@] execute succeed." >> "${LOG_PATH}"
}

logError() {
    echo -e "${ENV_COLOR_B_RED}[ERROR] $@${ENV_COLOR_RESET}"
    createLogFileIfNotExists
    echo "[${DATE}] [${USER}] [ERROR] [$0] [$@] execute failed." >> "${LOG_PATH}"
}

printInfo() {
    echo -e "${ENV_COLOR_B_GREEN}[INFO] $@${ENV_COLOR_RESET}"
}

printWarn() {
    echo -e "${ENV_COLOR_B_YELLOW}[WARN] $@${ENV_COLOR_RESET}"
}

printError() {
    echo -e "${ENV_COLOR_B_RED}[ERROR] $@${ENV_COLOR_RESET}"
}

callAndLog () {
    $*
    if [[ $? -eq ${ENV_SUCCEED} ]]; then
        echo -e "${ENV_COLOR_B_GREEN}[INFO] $@${ENV_COLOR_RESET}"
        logInfo "$@"
        return ${ENV_SUCCEED}
    else
        echo -e "${ENV_COLOR_B_RED}[ERROR] $@ EXECUTE FAILED.${ENV_COLOR_RESET}"
        logError "$@ EXECUTE FAILED"
        return ${ENV_FAILED}
    fi
}
